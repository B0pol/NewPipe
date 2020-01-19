package org.schabi.newpipe.util.translators;

import android.content.Context;

import org.schabi.newpipe.R;

/**
 * Created by B0pol on 2020-01-20.
 * LicenceTranslator.java is part of NewPipe.
 * <p>
 * NewPipe is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * NewPipe is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with NewPipe. If not, see <http://www.gnu.org/licenses/>.
 */

public final class LicenceTranslator {

    private LicenceTranslator() {
    }

    public static String getTranslatedLicenceName(
            final String licenceEnglishName, final Context c) {
        // Built from this: https://peertube.cpy.re/api/v1/videos/licences
        switch (licenceEnglishName) {
            case "Attribution":
                return c.getString(R.string.licence_title_attribution);
            case "Attribution - Share Alike":
                return c.getString(R.string.licence_title_attribution_share_alike);
            case "Attribution - No Derivatives":
                return c.getString(R.string.licence_title_attribution_no_derivatives);
            case "Attribution - Non Commercial":
                return c.getString(R.string.licence_title_attribution_non_commercial);
            case "Attribution - Non Commercial - Share Alike":
                return c.getString(R.string.licence_title_attribution_non_commercial_share_alike);
            case "Attribution - Non Commercial - No Derivatives":
                return c.getString(R.string.licence_title_attribution_non_commercial_no_derivates);
            case "Public Domain Dedication":
                return c.getString(R.string.licence_title_public_domain_dedication);
            default:
                return licenceEnglishName;
        }
    }

}
