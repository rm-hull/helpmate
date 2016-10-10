(ns helpmate.attributes
  (:require
   [clojure.string :as str]))

(defn expand [attrs]
  (when-not (empty? attrs)
    (str/join (for [[k v] attrs] (str " " (name k) "=\"" v "\"")))))

(defn extract-id [kword]
  (and
   (keyword? kword)
   (str/starts-with? (name kword) \#)
   (-> (name kword) (subs 1))))

(defn extract-classes [kword]
  (and
   (keyword? kword)
   (str/starts-with? (name kword) \.)
   (-> (name kword) (str/replace \. \space))))
