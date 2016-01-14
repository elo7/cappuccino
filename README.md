# Cappuccino

Writing interface tests using Espresso is not an easy task. Cappuccino was born to make your tests more fluid, and it's also a repository of utilities created for us developers.

# Examples:

* With Espresso:

    ```
    onView(withId(R.id.view_id)).perform(click());
    onView(withText("Hello World!")).check(matches(isDisplayed()));
    onView(withId(R.id.view_id)).perform(clearText());
    ```
* With Cappuccino:
    ```
    actionHasText("Hello World!").perform();
    actionClick().inView(R.id.view_id).perform();
    actionClearField().inView(R.id.view_id).perform();
    ```

You can also set a delay time before the Cappuccino perform the action, like:

```
actionClick().inView(R.id.view_id).withDelay(1000).perform();
```


# Download 

```
androidTestCompile 'com.elo7.cappuccino:cappuccino:0.2'
```
Feel free to submit a pull request with more awesome actions :)

# License 
```
Copyright 2016 Elo7, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

