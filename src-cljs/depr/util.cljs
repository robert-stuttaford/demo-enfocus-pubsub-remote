(ns depr.util)

(defn log
  [& more]
  (.apply (.-log js/console) js/console
          (into-array (map #(if (satisfies? cljs.core.ISeqable %)
                              (pr-str %)
                              %)
                           more))))