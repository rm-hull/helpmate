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

(deftest check-agglomerate-attrs
  (is (= {:children ["child1" "child2"]}
         (attrs/agglomerate ["child1" "child2"])))
  (is (= {:attrs {:id "carpet" :data-target "#nav"} :children ["something"]}
         (attrs/agglomerate [{:id "carpet" :data-target "#nav"} "something"])))
  (is (= {:attrs {:id "carpet" :data-target "#nav"} :children ["something"]}
         (attrs/agglomerate [:#carpet {:data-target "#nav"} "something"])))
  (is (= {:attrs {:id "rug" :data-target "#nav"} :children ["something"]}
         (attrs/agglomerate [:#carpet {:data-target "#nav" :id "rug"} "something"])))
  (is (= {:attrs {:id "carpet" :data-target "#nav"} :children ["something"]}
         (attrs/agglomerate [{:data-target "#nav" :id "rug"} :#carpet "something"])))
  (is (= {:attrs {:class "jim tom"}}
         (attrs/agglomerate [:.jim :.tom])))
  (is (= {:attrs {:class "alice bob chuck"}}
         (attrs/agglomerate [{:class "alice bob"} :.chuck])))
  (is (= {:attrs {:class "bob chuck"}}
         (attrs/agglomerate [:.alice {:class "bob chuck"}])))
  (is (= {:attrs {:class "alice" :data-index 3}}
         (attrs/agglomerate [:.alice {:data-index 3}])))
  (is (= {:attrs {:width 120 :height 130 :viewBox "0 0 120 120"}}
         (attrs/agglomerate [:width 120 :height 130 :viewBox "0 0 120 120"])))
  (is (= {:attrs {:width 120 :height 130} :children ["viewBox" "0 0 120 120"]}
         (attrs/agglomerate [:width 120 :height 130 "viewBox" "0 0 120 120"])))
  (is (= {:attrs {:cx "" :cy nil}}
         (attrs/agglomerate [:cx "" :cy nil])))
  (is (thrown? IllegalArgumentException
               (attrs/agglomerate [:width 120 :height [200 300]])))
  (is (thrown? IllegalArgumentException
               (attrs/agglomerate [:width 120 :height]))))
