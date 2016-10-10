(ns helpmate.attributes-test
  (:refer-clojure :exclude [comment])
  (:require
   [clojure.test :refer :all]
   [helpmate.attributes :as attrs]))

(deftest check-expand-attrs
  (is (nil? (attrs/expand nil)))
  (is (nil? (attrs/expand [])))
  (is (nil? (attrs/expand {})))
  (is (nil? (attrs/expand "")))
  (is (= " k=\"v\"" (attrs/expand [[:k "v"]])))
  (is (= " k=\"v\"" (attrs/expand [["k" "v"]])))
  (is (= " k=\"v\"" (attrs/expand {:k "v"})))
  (is (= " id=\"title\" class=\"flush--right\"" (attrs/expand {:id "title" :class "flush--right"}))))

