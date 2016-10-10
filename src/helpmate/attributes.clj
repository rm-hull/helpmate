(ns helpmate.attributes
  (:require
   [flatland.useful.experimental :refer [cond-let]]
   [clojure.string :as str]))

(defn expand [attrs]
  (when-not (empty? attrs)
    (str/join (for [[k v] attrs] (str " " (name k) "=\"" v "\"")))))

(defn extract-id [kword]
  (and
   (keyword? kword)
   (str/starts-with? (name kword) "#")
   (-> (name kword) (subs 1))))

(defn extract-classes [kword]
  (and
   (keyword? kword)
   (str/starts-with? (name kword) ".")
   (-> (name kword) (str/replace \. \space))))

(defn str-trim [& xs]
  (str/trim (apply str xs)))

(defn agglomerate [coll]
  (reduce
   (fn [acc val]
     (cond-let
      [id (extract-id val)]
      (assoc-in acc [:attrs :id] id)

      [classes (extract-classes val)]
      (update-in acc [:attrs :class] str-trim classes)

      [attrs (and (map? val) val)]
      (update-in acc [:attrs] merge attrs)

      :else
      (update-in acc [:children] concat [val])))
   {}
   coll))

