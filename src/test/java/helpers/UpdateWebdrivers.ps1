$browsers = @(
    @{
        Name = "chrome"
        PreviousUrl  = "https://chromedriver.storage.googleapis.com/2.46/chromedriver_win32.zip"
        LatestUrl = "https://chromedriver.storage.googleapis.com/LATEST_RELEASE"
    },
    @{
        Name = "firefox"
        PreviousUrl  = "https://github.com/mozilla/geckodriver/releases/download/v0.33.0/geckodriver-v0.33.0-win64.zip"
        LatestUrl = "https://github.com/mozilla/geckodriver/releases/latest/download/geckodriver-win64.zip"
    },
    @{
        Name = "edge"
        PreviousUrl  = "https://msedgedriver.azureedge.net/90.0.818.56/edgedriver_win64.zip"
        LatestUrl = "https://msedgedriver.azureedge.net/LATEST/msedgedriver_win64.zip"
    }
)

foreach ($browser in $browsers) {
    $browserName = $browser.Name
    $previousUrl  = $browser.PreviousUrl
    $latestUrl    = $browser.LatestUrl
    $webdriverPath = "C:\Users\kamil\Desktop\Inzynierka\src\test\resources\drivers\$browserName"
    $latestVersion = (Invoke-WebRequest -Uri $latestUrl).Content
    $webdriverDownloadUrl = "https://chromedriver.storage.googleapis.com/$latestVersion/${browserName}driver_win32.zip"
    $webdriverZipPath = Join-Path -Path $webdriverPath -ChildPath "${browserName}driver.zip"
    $webdriverExecutablePath = Join-Path -Path $webdriverPath -ChildPath "${browserName}driver.exe"
    Invoke-WebRequest -Uri $previousUrl -OutFile $webdriverZipPath
    Expand-Archive -Path $webdriverZipPath -DestinationPath $webdriverPath -Force
    Remove-Item -Path $webdriverZipPath -Force
    $env:Path += ";$webdriverPath"
    Write-Host "Downloaded and configured ${browserName^} WebDriver in version $latestVersion"
}

