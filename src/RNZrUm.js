import {
    NativeModules,Platform
} from 'react-native';
const { RNZrUm } = NativeModules;


export function initUM() {
    RNZrUm && RNZrUm.initUM();
}