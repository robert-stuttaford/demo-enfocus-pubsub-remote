(ns depr.views
  (:require [enfocus.core :as ef])
  (:require-macros [enfocus.macros :as em]))

(em/defsnippet item-template
  "templates/templates.html" [:#item-template]
  [item]
  [:dt] (em/content (str (:id item)))
  [:dd] (em/content (:title item)))

(em/defsnippet item-container-template
  "templates/templates.html" [:#item-container-template]
  [items]
  [:dl] (apply ef/en-content (map item-template items)))

(em/defaction render-items!
  [items]
  [:#content] (em/content (item-container-template items)))

(em/defaction append-item!
  [item]
  [:dl] (em/append (item-template item)))

(em/defaction init-views!
  [&{:keys [add-item-fn]}]
  [:#add-item-button] (em/listen :click add-item-fn))