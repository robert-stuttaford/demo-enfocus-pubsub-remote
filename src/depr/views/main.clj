(ns depr.views.main
  (:require [noir.core :as noir]
            [hiccup.page :as page]
            [hiccup.element :as element]))

(noir/defpartial js-app
  [js]
  (list
   ;; avoid loading deps.js in whitespace mode
   (if (re-find #"debug" js) (element/javascript-tag "var CLOSURE_NO_DEPS = true;"))
   (page/include-js (str "/js/" js ".js"))
   (element/javascript-tag "depr.app.run()")))

(noir/defpage "/" []
  (page/html5
   [:head
    [:title "Demo: Enfocus, PubSub, Remote."]]
   [:body
    [:div#content]
    [:button#add-item-button "Add item!"]
    ;; remove "-debug" to use production mode js
    (js-app "depr-debug")]))
