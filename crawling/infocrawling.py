from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.support.select import Select
from webdriver_manager.chrome import ChromeDriverManager
import time
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
import json


driver = webdriver.Chrome(service= Service(ChromeDriverManager().install()))
url_login = "https://info21.khu.ac.kr/com/LoginCtr/login.do?returnurl=https://portal.khu.ac.kr/ksign/index.jsp?ssoGb=ptfol&sso=ok"
url_table = "https://portal.khu.ac.kr/haksa/clss/clss/totTmTbl/index.do"

driver.get(url_login)
time.sleep(0.3)
tag_id = driver.find_element(By.XPATH,'//*[@id="userId"]')
tag_pw = driver.find_element(By.XPATH,'//*[@id="userPw"]')
tag_id.clear()
tag_pw.clear()
time.sleep(0.8)
tag_id.click()
tag_id.send_keys('dlwlrma2003')
time.sleep(0.8)
tag_pw.click()
tag_pw.send_keys('Dltjdqls1!')
time.sleep(0.8)
login_btn = driver.find_element(By.XPATH,'//*[@id="loginFrm"]/div/div[2]/div[1]/div[2]/button[1]')
login_btn.click()
time.sleep(1)

driver.get(url_table)
time.sleep(1)
selectCampus=Select(driver.find_element(By.XPATH,'//*[@id="searchCampsSeCode"]'))
selectCampus.select_by_value('2')
time.sleep(0.5)
selectOrgnz=Select(driver.find_element(By.XPATH,'//*[@id="searchOrgnzCode"]'))
selectOrgnz.select_by_value("A04754")
driver.find_element(By.XPATH,'//*[@id="searchBtn"]').click()

crawllist=list()
for k in range(1,6):#페이지(대)넘김
    for j in range(3,14):#페이지넘김
        for i in range(1,11): #1페이지
            selecting=driver.find_element(By.XPATH,'//*[@id="baseForm"]/div[2]/div[2]/table/tbody/tr[%s]/td[11]'%i).text
            if('공' in selecting or '품평실' in selecting or '실' in selecting):
                name=driver.find_element(By.XPATH,'//*[@id="baseForm"]/div[2]/div[2]/table/tbody/tr[%s]/td[5]'%i).text
                prof=driver.find_element(By.XPATH,'//*[@id="baseForm"]/div[2]/div[2]/table/tbody/tr[%s]/td[10]'%i).text
                crawllist.append([name,prof,selecting[:selecting.index('/')],selecting[selecting.index('/')+1:]])
        time.sleep(0.1)
        driver.execute_script("global.index(41); return false;")
        time.sleep(0.1)

jsonlist=list()
for i in crawllist:
    if(i[0]==" "or i[0]==''or i[0]==""): pass
    jsonlist.append({'name':i[0],'prof':i[1],'time':i[2],'class':i[3]})
print(jsonlist)
with open('crawlOut.json','w',encoding='utf-8') as f:
    json.dump(jsonlist,f, indent=3)
    
