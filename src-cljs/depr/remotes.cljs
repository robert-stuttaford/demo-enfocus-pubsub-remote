(ns depr.remotes
  (:require [depr.pubsub :as pubsub]
            [depr.util :as util]
            [shoreleave.remotes.http-rpc :as rpc])
  (:require-macros [shoreleave.remotes.macros :as srm]))

(defn items-loaded [items] items)
(def items-loaded-topic (pubsub/topic items-loaded))

(defn get-items
  []
  (srm/rpc (remotes/get-items) [result]
           (util/log "get-items result" result)
           (items-loaded-topic result)))
 