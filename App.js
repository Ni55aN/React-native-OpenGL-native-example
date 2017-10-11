/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View} from 'react-native';

import GLSurface from './glsurface';

export default class App extends Component < {} > {
  render() {
    return (
      <View style={styles.container}>
        <Text style={styles.welcome}>
          Native GLSurfaceView
        </Text>
        <GLSurface style={{
          width: 200,
          height: 200
        }}/>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF'
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10
  }
});
