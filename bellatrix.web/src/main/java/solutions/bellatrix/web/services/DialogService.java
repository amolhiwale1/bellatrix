/*
 * Copyright 2022 Automate The Planet Ltd.
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

package solutions.bellatrix.web.services;

import org.openqa.selenium.Alert;

import java.util.function.Consumer;
import java.util.function.Function;

public class DialogService extends WebService {
    public void handle(Function<Object, Alert> function, DialogButton dialogButton) {
        var alert = getWrappedDriver().switchTo().alert();
        function.apply(alert);
        if (dialogButton == DialogButton.OK) {
            alert.accept();
            getWrappedDriver().switchTo().defaultContent();
        } else {
            alert.dismiss();
            getWrappedDriver().switchTo().defaultContent();
        }
    }

    public void handle(Consumer<Alert> function, DialogButton dialogButton) {
        var alert = getWrappedDriver().switchTo().alert();
        function.accept(alert);
        if (dialogButton == DialogButton.OK) {
            alert.accept();
            getWrappedDriver().switchTo().defaultContent();
        } else {
            alert.dismiss();
            getWrappedDriver().switchTo().defaultContent();
        }
    }

    public void handle(DialogButton dialogButton) {
        var alert = getWrappedDriver().switchTo().alert();
        if (dialogButton == DialogButton.OK) {
            alert.accept();
            getWrappedDriver().switchTo().defaultContent();
        } else {
            alert.dismiss();
            getWrappedDriver().switchTo().defaultContent();
        }
    }

    public void handle() {
        handle((a) -> {
        }, DialogButton.OK);
    }

    public String getText() {
        var alert = getWrappedDriver().switchTo().alert();
        return alert.getText();
    }
}
