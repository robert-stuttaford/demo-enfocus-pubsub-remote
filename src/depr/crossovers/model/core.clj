(ns depr.crossovers.model.core
	(:require [depr.util :as util]))

(defn make-item
	[num]
	{:id num :title (str "Item #" num)})