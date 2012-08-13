(ns depr.remotes
	(:require [depr.crossovers.model.core :as model]
						[depr.util :as util]))

(defn get-items
	[]
	(util/log "get-items remote invoked.")
	(dotimes [i 5] (model/make-item i)))