(ns depr.app
  (:require [enfocus.core :as ef]
            [depr.pubsub :as pubsub]
            [depr.views :as views]
            [depr.crossovers.model.core :as model]
            [depr.remotes :as remotes]
            [depr.util :as util])
  (:require-macros [enfocus.macros :as em]))

(def counter (atom 10))

(defn update-item-count!
  [items]
  (reset! counter (dec (count items))))

(defn add-item!
  []
  (swap! counter inc)
  (remotes/add-item (model/make-item @counter)))

(defn item-added!
  [item]
  (views/append-item! item))

(defn ^:export run
  []
  (util/log "start up")
  (pubsub/subscribe remotes/items-loaded-topic update-item-count!)
  (pubsub/subscribe remotes/items-loaded-topic views/render-items!)
  (pubsub/subscribe remotes/item-added-topic item-added!)
  (views/init-views! :add-item-fn add-item!)
  (em/wait-for-load
   (remotes/get-items)))
