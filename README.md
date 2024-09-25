Make sure that you have java 17, maven, and allure

Clone the repository git clone https://github.com/shrikantMarkad/EntraSDET.git

After this process completes then navigate to clonned_dir/EntraSDET/EntraSDET/

Make sure you able to see all project files along with pom & testng xml files

In the same directory open command prompt

Add command as mvn verify

Execution will trigger and you will find result under allure-results folder

To open allure you have to be projects root folder where you see allure-results folder

If you see expected folder(refresh dir if required) then open command prompt

type "allure serve allure-results"(don't add double quotes while adding command) & press enter

Report will be opened in any of the default browser

Note: try to fail one of the test intentionally so that you will see failure screenshot to the allure report(append any char to page tile and rerun with same steps)
