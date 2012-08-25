(ns depr.util
  (:require [taoensso.timbre :as timbre]))

(defn log
  [& vs]
  (timbre/info vs))