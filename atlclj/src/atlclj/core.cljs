(ns atlclj.core
  (:require-macros [natal-shell.core :refer [with-error-view]]
                   [natal-shell.components :refer [view text image touchable-highlight]]
                   [natal-shell.alert :refer [alert]])
  (:require [om.core :as om]))

(set! js/React (js/require "react-native/Libraries/react-native/react-native.js"))

(defonce app-state (atom {:text "Welcome to atlclj"}))

(defn main-view [data owner]
  (reify
    om/IRender
    (render [this]
      (with-error-view
        (view
          {:style
            {:flexDirection "column" 
             :margin 20 
             :alignItems "center"}}
          (view {:style {:position "absolute"
                         :top 10 :left 10 
                         :backgroundColor "#ff0000" 
                         :height 20 :width 20}})

          (text
            {:style
              {:fontSize 50 
               :fontWeight "100"
               :marginBottom 20
               :textAlign "center"}}
            (:text data))

          
          (image
            {:source
              {:uri "https://raw.githubusercontent.com/cljsinfo/logo.cljs/master/cljs.png"}
             :style {:width 80 
                     :height 80 
                     :marginBottom 0}})

          (view 
            {:style 
             {:flexDirection "row" 
              :margin 13 
              :alignItems "center"}}
          (touchable-highlight
            {:style {:backgroundColor "#999" 
                     :padding 10 
                     :borderRadius 5}
             :onPress #(alert "HELLO!")}

            (text
              {:style {:color "white" :textAlign "center" :fontWeight "bold"}}
              "press me"))

          (touchable-highlight
            {:style {:backgroundColor "#999" :padding 10  :margin 13 :borderRadius 5}
             :onPress #(alert "HELLO!")}

            (text
              {:style {:color "white" :textAlign "center" :fontWeight "bold"}}
              "press me"))

          (touchable-highlight
            {:style {:backgroundColor "#999" :padding 10 :borderRadius 5}
             :onPress #(alert "HELLO!")}

            (text
              {:style {:color "white" :textAlign "center" :fontWeight "bold"}}
              "press me"))))))))


(om/root main-view app-state {:target 1})
