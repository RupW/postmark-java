// The MIT License
//
// Copyright (c) 2010 Jared Holdcroft
//
// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files (the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:
//
// The above copyright notice and this permission notice shall be included in
// all copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
// THE SOFTWARE.

package com.postmark.java;

import java.util.*;

/**
 * Command-line test client.
 */

public class TestClient {

    public static void main(String[] args)
    {
        List<NameValuePair> headers = new ArrayList<NameValuePair>();

        headers.add(new NameValuePair("HEADER", "test"));

        PostmarkMessage message = new PostmarkMessage(args[0],
                args[1],
                args[0],
                args[2],
                args[3],
                args[4],
                args[5],
                false,
                args[6],
                headers);


        String apiKey = "POSTMARK_API_TEST";
        if(args[7] != null)
            apiKey = args[7];
            

        PostmarkClient client = new PostmarkClient(apiKey);

        try {
            client.sendMessage(message);
        } catch (PostmarkException pe) {
            System.out.println("An error has occurred : " + pe.getMessage());
        }
    }
}
