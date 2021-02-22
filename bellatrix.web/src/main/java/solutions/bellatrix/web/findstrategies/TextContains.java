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

package solutions.bellatrix.web.findstrategies;

import org.openqa.selenium.By;

public class TextContains extends FindStrategy {
    public TextContains(String value)
    {
        super(value);
    }

    public static TextContains by(String value) {
        return new TextContains(value);
    }

    @Override
    public By convert() {
        return By.xpath(String.format("//*[contains(text(), '%s')]", getValue()));
    }

    @Override
    public String toString() {
        return String.format("text containing %s", getValue());
    }
}