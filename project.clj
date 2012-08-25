(defproject demo-enfocus-pubsub-remote "0.1.0-SNAPSHOT"
  :description "Demo of Enfocus, PubSub and Remotes working together."
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [noir "1.3.0-beta8"]
                 [enfocus "1.0.0-SNAPSHOT"]
                 [amalloy/ring-gzip-middleware "0.1.2"]
                 [ring-anti-forgery "0.2.0"]
                 [shoreleave/shoreleave-pubsub "0.2.2-SNAPSHOT"]
                 [shoreleave/shoreleave-remote "0.2.2-SNAPSHOT"]
                 [shoreleave/shoreleave-remote-noir "0.2.2-SNAPSHOT"]
                 [com.taoensso/timbre "0.8.0"]]
  :plugins [[lein-cljsbuild "0.2.4"]]
  :main depr.server
  :cljsbuild {
    :crossovers [depr.crossovers]
    :crossover-jar false
    :builds {
      :dev
      {:source-path "src-cljs"
       :jar true
       :compiler {:output-to "resources/public/js/depr-debug.js"
                  :optimizations :whitespace
                  :pretty-print true}}
      :prod
      {:source-path "src-cljs"
       :compiler {:output-to "resources/public/js/depr.js"
                  :optimizations :advanced
                  :pretty-print false
                  :sourcemap true}}}})
