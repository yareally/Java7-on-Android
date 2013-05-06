/*
Copyright (c) 2012 Wes Lanning, http://codingcreation.com

Permission is hereby granted, free of charge, to any person obtaining
a copy of this software and associated documentation files (the
"Software"), to deal in the Software without restriction, including
without limitation the rights to use, copy, modify, merge, publish,
distribute, sublicense, and/or sell copies of the Software, and to
permit persons to whom the Software is furnished to do so, subject to
the following conditions:

The above copyright notice and this permission notice shall be
included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

http://www.opensource.org/licenses/mit-license.php
*/

package cc;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import cc.io._BufferedInputStream;
import cc.io._FileInputStream;
import cc.io._FileOutputStream;
import cc.test.R;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestActivity extends Activity
{
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        try {
            // obviously does not exist so our exception will be caught.
            Method multiCatchTest = getClass().getDeclaredMethod("doesNotExist");
        } catch (SecurityException | NoSuchMethodException | IllegalArgumentException e) {
            Toast.makeText(this,
                "Multicatch exception was caught, yay",
                Toast.LENGTH_LONG).show();
        }

        /* Java 8 won't work...

        Comparator<Integer> cmp = (x, y) -> (x < y) ? -1 : ((x > y) ? 1 : 0);

        if (cmp.compare(1, 2) == -1) {
            Toast.makeText(this, "1 is less than 2", Toast.LENGTH_LONG).show();
        }*/

        String[] months = {
            "JAN",
            "FEB",
            "MAR",
            "APR",
            "MAY",
            "JUN",
            "JUL",
            "AUG",
            "SEP",
            "OCT",
            "NOV",
            "DEC"};

        int m = getRandomMonth(12);

        Toast.makeText(this,
            String.format(
                "%s has %d days in its month.",
                months[m],
                getDaysInMonth(months[m])),
            Toast.LENGTH_LONG).show();

        // showing "try with resources"
        try (_FileOutputStream fos = new _FileOutputStream("/sdcard/testfile.txt")) {
            // integer literals work, yay
            Toast.makeText(this,
                String.format(
                    "Shown as 1_000 and 2_000 in the IDE, but shown as %d %d in Android as they should",
                    1_000, 2_000),
                Toast.LENGTH_LONG).show();

            byte[] writeData = new byte[] {
                (byte) 222, (byte) 128
            };

            fos.write(writeData);
            Toast.makeText(this,
                String.format(
                    "Written to testfile.txt: %d %d",
                    222, 128),
                Toast.LENGTH_LONG).show();
        } catch (IOException ioe) {
            Toast.makeText(this,
                String.format(
                    "Error: %s",
                    ioe.getMessage()),
                Toast.LENGTH_LONG).show();
        }

        try (_FileInputStream fis = new _FileInputStream("/sdcard/testfile.txt")) {
            // to show "diamonds" working
            List<String> readData = new ArrayList<>(4);
            int nextInt;

            while ((nextInt = fis.read()) != -1) {
                readData.add(String.valueOf(nextInt));
            }

            Toast.makeText(
                this,
                String.format(
                    "Read data from testfile.txt: %s",
                    readData.toString()),
                Toast.LENGTH_LONG).show();
        } catch (IOException ioe) {
            Toast.makeText(this,
                String.format(
                    "Error: %s",
                    ioe.getMessage()),
                Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Demonstrates that string switches are working.
     *
     * @param month
     * @return
     */
    public static int getDaysInMonth(String month)
    {
        switch (month) {
            case "JAN":
                return 31;
            case "FEB":
                return 28;
            case "MAR":
                return 31;
            case "APR":
                return 30;
            case "MAY":
                return 31;
            case "JUN":
                return 30;
            case "JUL":
            case "AUG":
                return 31;
            case "SEP":
                return 30;
            case "OCT":
                return 31;
            case "NOV":
                return 30;
            case "DEC":
                return 31;
            default:
                return 0;
        }
    }

    public static int getRandomMonth(int limit)
    {
        return (int) (Math.random() * limit);
    }
}
