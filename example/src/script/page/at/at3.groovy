@Grab('org.gebish:geb-core:0.10.0')
@Grab('org.seleniumhq.selenium:selenium-htmlunit-driver:2.44.0')
import geb.Browser
import geb.Page

driver = 'htmlunit'

Browser.drive {
    to GebHomePage
    item1.click(CrossBrowserPage)
}.quit()

class GebHomePage extends Page {

    static at = {$('#main h1').first().text() == 'What is it?' }

    static url = "http://www.gebish.org"

    static content = {
        item1 { $('#sidebar li a').first() }
    }
}

class CrossBrowserPage extends Page {

    // // 故意定義錯的檢查條件
    static at = {$('#main h1').first().text() == 'Cross Browser Automation2'}

    static url = "http://www.gebish.org/crossbrowser"

    static content = {
        topic3 { $('#main h1').last().text() }
    }
}