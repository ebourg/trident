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
 * Joins two easing functions, one for the first half of the movement,
 * the other for the second half.
 * 
 * @author Emmanuel Bourg
 * @version $Revision$, $Date$
 */
public class InOut implements TimelineEase {

    private TimelineEase easeIn;
    private TimelineEase easeOut;

    public InOut(TimelineEase ease) {
        this.easeIn = new Reverse(ease);
        this.easeOut = ease;
    }

    public InOut(TimelineEase easeIn, TimelineEase easeOut) {
        this.easeIn = easeIn;
        this.easeOut = easeOut;
    }

    public float map(float t) {
        if (t < 0.5f) {
            return easeIn.map(t * 2) * .5f;
        } else {
            return easeOut.map(t * 2 - 1) * .5f + .5f;
        }
    }
}
