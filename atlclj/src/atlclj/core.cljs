(ns atlclj.core
  (:require-macros [natal-shell.core :refer [with-error-view]]
                   [natal-shell.components :refer [view text image touchable-highlight]]
                   [natal-shell.alert :refer [alert]])
  (:require [om.core :as om]))

(set! js/React (js/require "react-native/Libraries/react-native/react-native.js"))

(defonce app-state (atom {:text "Welcome to atlclj"}))

(defn peach-image []
  (image
    {:source
     {:uri "./peach.png"}
     :style {:width 80 
             :height 80 }}))

(defn main-view [data owner]
  (reify
    om/IRender
    (render [this]
      (with-error-view
        (view
          {:style
           {:flexDirection "column" 
            :margin 0 
            :top 69
            :alignItems "center"  }}

          (text
            {:style
             {:fontSize 52 
              :fontWeight "100"
              :marginBottom 20
              :textAlign "center"}}
            (:text data))

          (image
            {:source
             {:uri "https://raw.githubusercontent.com/cljsinfo/logo.cljs/master/cljs.png"}
             :style {:width 80 
                     :height 80 }})

          (peach-image) 

          (view 
            {:style 
             {:flexDirection "row" 
              :margin 13 
              :alignItems "center"}}

            (touchable-highlight
              {:style {:backgroundColor "#ffdd00"
                       :padding 10 
                       :borderRadius 5}
               :onPress #(alert "yo")}

              (text
                {:style {:color "white" :textAlign "center" :fontWeight "bold"}}
                "Left"))

            (touchable-highlight
              {:style {:backgroundColor "#999" :padding 10  
                       :margin 13 :borderRadius 5}
               :onPress #(alert "Hola")}

              (text
                {:style {:color "white" :textAlign "center" :fontWeight "bold"}}
                "Center"))

            (touchable-highlight
              {:style {:backgroundColor "#999" :padding 10 :borderRadius 5}
               :onPress #(alert "Right Button")}

              (text
                {:style {:color "white" :textAlign "center" :fontWeight "bold"}}
                "Right"))))))))


(om/root main-view app-state {:target 1})
