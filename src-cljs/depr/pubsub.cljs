(ns depr.pubsub
  (:require [shoreleave.pubsubs.simple :as simplebus]
            [shoreleave.pubsubs.protocols :as pubsub]))

(def ^:private bus (simplebus/bus))

(defn topic
  [f]
  (pubsub/publishize f bus))

(defn subscribe
  [topic & fs]
  (doseq [f fs]
    (pubsub/subscribe bus topic f)))
