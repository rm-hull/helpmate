(ns helpmate.attributes-test
  (:refer-clojure :exclude [comment])
  (:require
   [clojure.test :refer :all]
   [helpmate.attributes :as attrs]))

(deftest check-extract-id
  (is (false? (attrs/extract-id "fred")))
  (is (false? (attrs/extract-id :fred)))
  (is (false? (attrs/extract-id :.fred)))
  (is (false? (attrs/extract-id {:id "fred"})))
  (is (= "fred" (attrs/extract-id :#fred))))

(deftest check-extract-classes
  (is (false? (attrs/extract-classes "john.paul.george.ringo")))
  (is (false? (attrs/extract-classes :john.paul.george.ringo)))
  (is (false? (attrs/extract-classes :#john.paul.george.ringo)))
  (is (false? (attrs/extract-classes {:class "john paul george ringo"})))
  (is (= " john paul george ringo" (attrs/extract-classes :.john.paul.george.ringo))))

(deftest check-expand-attrs
  (is (nil? (attrs/expand nil)))
  (is (nil? (attrs/expand [])))
  (is (nil? (attrs/expand {})))
  (is (nil? (attrs/expand "")))
  (is (= " k=\"v\"" (attrs/expand [[:k "v"]])))
  (is (= " k=\"v\"" (attrs/expand [["k" "v"]])))
  (is (= " k=\"v\"" (attrs/expand {:k "v"})))
  (is (= " id=\"title\" class=\"flush--right\"" (attrs/expand {:id "title" :class "flush--right"}))))

