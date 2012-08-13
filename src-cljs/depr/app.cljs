(ns depr.app
  (:require [enfocus.core :as ef]
            [depr.pubsub :as pubsub]
            [depr.views :as views]
            [depr.crossovers.model.core :as model]
            [depr.remotes :as remotes]
            [depr.util :as util])
  (:require-macros [enfocus.macros :as em]))

(def counter (atom 10))

(defn add-item!
  []
  (swap! counter inc)
  (views/append-item! (model/make-item @counter)))

(defn ^:export run
  []
  (util/log "start up")
  (pubsub/subscribe remotes/items-loaded-topic views/render-items!)
  (views/init-views! :add-item-fn add-item!)
  (em/wait-for-load
   (remotes/get-items)))
