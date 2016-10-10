(ns helpmate.core-test
  (:refer-clojure :exclude [comment])
  (:require
   [clojure.test :refer :all]
   [helpmate.core :refer :all]))

(deftest check-attrs
  (is (nil? (expand-attrs nil)))
  (is (nil? (expand-attrs [])))
  (is (nil? (expand-attrs {})))
  (is (nil? (expand-attrs "")))
  (is (= " k=\"v\"" (expand-attrs [[:k "v"]])))
  (is (= " k=\"v\"" (expand-attrs [["k" "v"]])))
  (is (= " k=\"v\"" (expand-attrs {:k "v"})))
  (is (= " id=\"title\" class=\"flush--right\"" (expand-attrs {:id "title" :class "flush--right"}))))
