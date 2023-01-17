//
//  InfoItem.swift
//  iosApp
//
//  Created by Rahul Gupta on 17/01/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct InfoItem: View {
    var infoItem : InfoEntity
    var onDelete : () -> Void
    var body: some View {
        HStack(){
            Text(infoItem.firstName + " " + infoItem.secondName)
                .padding()
            
            Spacer()
            
            Button(action: onDelete){
                Image(systemName: "xmark")
                    .foregroundColor(.black)
            }.padding()
        }
    }
}

struct InfoItem_Previews: PreviewProvider {
    static var previews: some View {
        InfoItem(
            infoItem: InfoEntity(
                id: 1, firstName: "Rahul", secondName: "Gupta"
            ),
            onDelete: {})
    }
}
