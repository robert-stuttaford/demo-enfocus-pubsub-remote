(ns depr.views.main
  (:use [noir.core :only [defpage defpartial]]
        [hiccup.element :only [javascript-tag]]
        [hiccup.page :only [html5 include-js]]))

(defpartial js-app
  [& {:keys [js whitespace-only?] :or {js "main" whitespace-only? false}}]
  (list
    ;; avoid loading deps.js in whitespace mode
    (if whitespace-only? (javascript-tag "var CLOSURE_NO_DEPS = true;"))
    (include-js (str "/js/" js ".js"))
    (javascript-tag "depr.app.run()")))

(defpage "/" []
  (html5
   [:head
    [:title "Demo: Enfocus, PubSub, Remote."]]
   [:body
    [:div#content]
    [:button#add-item-button "Add item!"]
    ;; remove the js and whitespace-only? optional params to use production mode js
    (js-app :js "main-debug" :whitespace-only? true)]))
