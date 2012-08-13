(ns depr.server
  (:require [noir.server :as server]
            [noir.shoreleave.rpc :as rpc]
            [ring.middleware.gzip :as gzip]
            [ring.middleware.anti-forgery :as anti-forgery]
            [depr.remotes]))

(server/load-views-ns 'depr.views)

(rpc/activate-remotes!)
(rpc/remote-ns 'depr.remotes :as "remotes")

(server/add-middleware ring.middleware.gzip/wrap-gzip)
(server/add-middleware ring.middleware.file-info/wrap-file-info)
#_(server/add-middleware ring.middleware.anti-forgery/wrap-anti-forgery)

(defn -main [& m]
  (let [mode (keyword (or (first m) :dev))
        port (Integer. (get (System/getenv) "PORT" "8080"))]
    (server/start port {:mode mode
                        :ns 'depr})))
