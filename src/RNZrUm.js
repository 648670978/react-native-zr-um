import {
    NativeModules,Platform
} from 'react-native';
const { RNZrUm } = NativeModules;


export function init(appKey,channel) {
    RNZrUm && RNZrUm.init(appKey,channel);
}