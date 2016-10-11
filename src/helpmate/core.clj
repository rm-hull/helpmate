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

(ns helpmate.core
  (:refer-clojure :exclude [comment])
  (:require
   [clojure.string :as str]
   [helpmate.attributes :as attrs]))

(defn elem
  ([tag]
   (elem tag true false))

  ([tag self-closing? empty-tag?]
   (if (keyword? tag)
     (elem (name tag) self-closing?)
     (fn [& more]
       (let [{:keys [attrs children]} (attrs/agglomerate (flatten more))
             attrs                    (attrs/expand attrs)
             no-children?             (empty? children)]

         (cond
           empty-tag?
           (if no-children?
             (str "<" tag attrs ">")
             (throw (IllegalArgumentException. (str "Element '" tag "' cannot accept children"))))

           (and self-closing? no-children?)
           (str "<" tag attrs "/>")

           :else
           (str "<" tag attrs ">" (str/join children) "</" tag ">")))))))

(defmacro defelem [tag & [doc-string]]
  (let [opts (meta tag)
        doc-string (or doc-string "")]
    `(def ~tag ~doc-string (elem ~(name tag) ~(not (:non-void opts)) ~(:empty-tag opts)))))
