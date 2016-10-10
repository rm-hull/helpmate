(ns helpmate.html-test
  (:refer-clojure :exclude [comment])
  (:require
   [clojure.test :refer :all]
   [helpmate.core :refer :all]
   [helpmate.html :refer :all]))

; Temporary...
(defelem ^:non-void script)
(defelem ul)
(defelem span)

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
               (div {:id "main"})))))
