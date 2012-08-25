# Demo: Enfocus, Shoreleave's PubSub and Remotes, and cljsbuild's Crossovers

## What's in the box

* Noir on the back
* ClojureScript on the client
* Shoreleave's Remotes to move pure Clojure data between the two
* Enfocus to build views client-side from plain html templates (no special interleaved template syntax)
* Shoreleave's PubSub to declaratively bind views and model/remotes code together in a loosely coupled fashion
* Model code is shared between client and server, using cljsbuild's crossovers

Feedback most welcome.

## How to run

Using either Leiningen 1 or 2:

```
lein deps
lein cljsbuild once
lein run
```