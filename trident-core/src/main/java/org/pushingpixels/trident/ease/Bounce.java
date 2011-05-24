/**
 * Copyright 2011 Emmanuel Bourg
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.pushingpixels.trident.ease;

/**
 * Realistic bounce interpolation.
 *
 * @author Emmanuel Bourg
 * @version $Revision$, $Date$
 */
public class Bounce implements TimelineEase {

    /** The non normalized duration of the bounces */
    private final float d;

    /** The time positions where a bounce occurs (non normalized in the [0,1] interval) */
    private final float[] bounceTime;

    /** The time positions where a bounce reaches its maximum height (non normalized in the [0,1] interval) */
    private final float[] peakTime;

    /** The heights reached after each bounce */
    private final float[] height;

    /**
     * Creates an interpolator for 3 bounces. The coefficient of restitution
     * is computed such that the height of the last bounce is 5% of the
     * initial height.
     */
    public Bounce() {
        this(3);
    }

    /**
     * Creates an interpolator for n bounces. The coefficient of restitution
     * is computed such that the height of the last bounce is 5% of the
     * initial height.
     *
     * @param n the number of bounces
     */
    public Bounce(int n) {
        this(n, Math.pow(0.05, 1d / (2 * n)));
    }

    /**
     * Creates an interpolator for n bounces with the specified coefficient
     * of restitution.
     *
     * @param n the number of bounces
     * @param k the coefficient of restitution
     */
    public Bounce(int n, double k) {
        bounceTime = new float[n + 1];
        peakTime = new float[n + 1];
        height = new float[n + 1];
        
        for (int i = 0; i < n + 1; i++) {
            bounceTime[i] = getBounce(i, k);
            height[i] = (float) Math.pow(k, 2 * i);
            peakTime[i] = (float) (bounceTime[i] - Math.pow(k, i));
        }
        
        d = bounceTime[n];
    }

    /**
     * Returns the time position of the i-th bounce (non normalized in the [0,1] interval)
     * 
     * @param i the bounce number
     * @param k the coefficient of restitution
     */
    private float getBounce(int i, double k) {
        return (float) (2 * (1 - Math.pow(k, i + 1)) / (1 - k) - 1);
    }

    public float map(float t) {
        t = t * d;
        for (int i = 0; i < bounceTime.length; i++) {
            if (t <= bounceTime[i]) {
                t =  t - peakTime[i];
                return t * t + (1 - height[i]);
            }
        }
        
        return 1;
    }
}
