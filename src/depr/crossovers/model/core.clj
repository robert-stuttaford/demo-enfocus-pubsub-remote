(ns depr.crossovers.model.core
	(:require [depr.util :as util]))

(defn make-item
	[num]
	(util/log "make-item invoked with " num)
	{:id num :title (str "Item #" num)})