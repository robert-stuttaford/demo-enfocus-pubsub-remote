(ns depr.remotes
	(:require [depr.crossovers.model.core :as model]
						[depr.util :as util]))

(def items (atom []))

(defn add-item
	[item]
	(util/log "add-item remote invoked with " item)
	(swap! items conj item)
	item)

(dotimes [i 3] (add-item (model/make-item i)))

(defn get-items
	[]
	(util/log "get-items remote invoked.")
	@items)