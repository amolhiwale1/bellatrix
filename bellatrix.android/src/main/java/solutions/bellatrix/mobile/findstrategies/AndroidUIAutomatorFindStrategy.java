/*
 * Copyright 2021 Automate The Planet Ltd.
 * Author: Anton Angelov
 * Licensed under the Apache License, Version 2.0 (the "License");
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package solutions.bellatrix.mobile.findstrategies;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.util.List;

public class AndroidUIAutomatorFindStrategy extends FindStrategy {
    public AndroidUIAutomatorFindStrategy(String value)
    {
        super(value);
    }

    @Override
    public MobileElement findElement(AndroidDriver<MobileElement> driver) {
        return driver.findElementByAndroidUIAutomator(getValue());
    }

    @Override
    public List<MobileElement> findAllElements(AndroidDriver<MobileElement> driver) {
        return driver.findElementsByAndroidUIAutomator(getValue());
    }

    @Override
    public MobileElement findElement(MobileElement element) {
        // AndroidUIAutomatorFindStrategy not supported for searching inside another element.
        return null;
    }

    @Override
    public List<MobileElement> findAllElements(MobileElement element) {
        // AndroidUIAutomatorFindStrategy not supported for searching inside another element.
        return null;
    }

    @Override
    public String toString() {
        return String.format("androidUIAutomator = %s", getValue());
    }
}