(ns depr.util
  (:require [clojure.pprint :as pp]))

(defn log
  [& vs]
  (pp/pprint vs))