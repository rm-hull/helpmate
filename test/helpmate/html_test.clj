;; The MIT License (MIT)
;;
;; Copyright (c) 2016 Richard Hull
;;
;; Permission is hereby granted, free of charge, to any person obtaining a copy
;; of this software and associated documentation files (the "Software"), to deal
;; in the Software without restriction, including without limitation the rights
;; to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
;; copies of the Software, and to permit persons to whom the Software is
;; furnished to do so, subject to the following conditions:
;;
;; The above copyright notice and this permission notice shall be included in all
;; copies or substantial portions of the Software.
;;
;; THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
;; IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
;; FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
;; AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
;; LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
;; OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
;; SOFTWARE.

(ns helpmate.html-test
  (:refer-clojure :exclude [comment meta map time])
  (:require
   [clojure.test :refer :all]
   [helpmate.core :refer :all]
   [helpmate.html :refer :all]))

(deftest check-embedded-tags
  (is (= "<html id=\"main\"><script type=\"text/javascript\" src=\"foobar.js\"></script><div class=\"side-panel\"><p>hello<span class=\"highlight\">world</span></p><ul><li>1</li><li>2</li><li>3</li></ul></div><div id=\"main\"></div></html>"
         (html {:id "main"}
               (script {:type "text/javascript" :src "foobar.js"})
               (div {:class "side-panel"}
                    (p
                     "hello"
                     (span {:class "highlight"} "world"))
                    (ul
                     (for [x (range 1 4)]
                       (li x))))
               (div {:id "main"}))))

  (is (= "<html id=\"main\"><script type=\"text/javascript\" src=\"foobar.js\"></script><div class=\"side-panel\"><p>hello<span class=\"highlight\">world</span></p><ul><li>1</li><li>2</li><li>3</li></ul></div><div id=\"main\"></div></html>"
         (html :#main
               (script {:type "text/javascript" :src "foobar.js"})
               (div :.side-panel
                    (p
                     "hello"
                     (span :.highlight "world"))
                    (ul
                     (for [x (range 1 4)]
                       (li x))))
               (div :#main)))))

(deftest check-empty-tags
  (for [tag '[area base br col embed hr
              img input keygen link meta
              param source track wbr]]
    (is (thrown-with-msg? IllegalArgumentException #"Element '.*' cannot accept children")
        (tag "hello"))))
