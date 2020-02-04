set MyProject=C:\Users\30346.vendor\git\ElsevierSite\Elsevier
echo %MyProject%
set classpath=%MyProject%\bin;%MyProject%\Jar\*
echo %classpath%
java org.testng.TestNG %MyProject%\UserProductPurchase.xml
