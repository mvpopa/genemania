/**
 * This file is part of GeneMANIA.
 * Copyright (C) 2010 University of Toronto.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */
package org.genemania.engine.core.integration.attribute;

import org.genemania.engine.core.integration.Feature;
import org.genemania.engine.core.utils.ObjectSelector;
import org.genemania.exception.ApplicationException;

/*
 * rank-leveled
 */
public class TopXByGroupSelector implements IAttributeSelector {
    
    private int requestSize;
    private int maxSize;

    public TopXByGroupSelector(int requestSize, int maxSize) {
        super();
        this.requestSize = requestSize;
        this.maxSize = maxSize;
    }
    
    @Override
    public ObjectSelector<Feature> selectGroupAttributes(
            ObjectSelector<Feature> rankedFeatures) throws ApplicationException {

        return rankedFeatures.selectLevelledSmallestScores(requestSize, maxSize);
    }

    @Override
    public ObjectSelector<Feature> selectOverallAttributes(
            ObjectSelector<Feature> rankedFeatures) throws ApplicationException {

        return rankedFeatures;
    }

}
