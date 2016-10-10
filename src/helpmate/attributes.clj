(ns helpmate.attributes
  (:require
   [clojure.string :as str]))

(defn expand [attrs]
  (when-not (empty? attrs)
    (str/join (for [[k v] attrs] (str " " (name k) "=\"" v "\"")))))
