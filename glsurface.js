'use strict';

import PropTypes from 'prop-types';
import {requireNativeComponent, View} from 'react-native';

var iface = {
    name: 'GLSurface',
    propTypes: {
        ...View.propTypes
    }
};

export default requireNativeComponent('GLSurface', iface);