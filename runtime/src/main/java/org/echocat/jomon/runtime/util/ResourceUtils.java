/*****************************************************************************************
 * *** BEGIN LICENSE BLOCK *****
 *
 * Version: MPL 2.0
 *
 * echocat Jomon, Copyright (c) 2012 echocat
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 *
 * *** END LICENSE BLOCK *****
 ****************************************************************************************/

package org.echocat.jomon.runtime.util;

import javax.annotation.Nullable;

public class ResourceUtils {

    public static void closeQuietly(@Nullable AutoCloseable autoCloseable) {
        try {
            if (autoCloseable != null) {
                autoCloseable.close();
            }
        } catch (Exception ignored) {}
    }

    public static <T extends AutoCloseable> void closeQuietly(@Nullable Iterable<? extends T> elements) {
        try {
            if (elements != null) {
                for (Object element : elements) {
                    if (element instanceof AutoCloseable) {
                        closeQuietly((AutoCloseable) element);
                    }
                }
            }
        } catch (Exception ignored) {}
    }

    public static <T extends AutoCloseable> void closeQuietly(@Nullable T[] elements) {
        try {
            if (elements != null) {
                for (Object element : elements) {
                    if (element instanceof AutoCloseable) {
                        closeQuietly((AutoCloseable) element);
                    }
                }
            }
        } catch (Exception ignored) {}
    }

    private ResourceUtils() {}
}
