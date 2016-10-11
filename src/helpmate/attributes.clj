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

(defn- str-trim [& xs]
  (str/trim (apply str xs)))

(defn- collator [acc val]
  (cond-let
   [kw (:kw acc)]
   (if (or (string? val) (number? val) (nil? val))
     (->
      acc
      (dissoc :kw)
      (assoc-in [:attrs kw] val))
     (throw (IllegalArgumentException.
             (str  "Bare attribute '" kw "' expects following arg to be nil, string or number only"))))

   [id (extract-id val)]
   (assoc-in acc [:attrs :id] id)

   [classes (extract-classes val)]
   (update-in acc [:attrs :class] str-trim classes)

   [attrs (and (map? val) val)]
   (update-in acc [:attrs] merge attrs)

   [kw (and (keyword? val) val)]
   (assoc acc :kw kw)

   :else
   (update-in acc [:children] concat [val])))

(defn agglomerate [coll]
  (let [res (reduce collator {} coll)]
    (if-let [kw (:kw res)]
      (throw (IllegalArgumentException.
              (str "Bare attribute '" kw "' has no value")))
      res)))

