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

(ns helpmate.core-test
  (:require
   [clojure.test :refer :all]
   [helpmate.core :refer :all]))

(deftest check-elem
  (let [a (elem :a)
        b (elem :b true false)
        c (elem :c false true)
        d (elem :d false false)]
    (is (= "<a/>" (a)))
    (is (= "<b data-idx=\"3\"/>" (b :data-idx 3)))
    (is (= "<a><b/></a>" (a (b))))
    (is (= "<c>" (c)))
    (is (thrown? IllegalArgumentException (c (d))))
    (is (= "<d></d>" (d)))))

(defelem e1 "some docstring")
(defelem e2)

;(deftest check-docstring
;  (is (= "some docstring" (:documentation (meta e1))))
;  (is (= "" (:documentation (meta e2)))))
