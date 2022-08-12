import {Component, OnInit} from '@angular/core';
import {StoredRequestsService} from "../../services/stored-requests.service";
import {FolderTree} from "../../model/reguests/treeview.model";

@Component({
    selector: 'app-requests',
    templateUrl: './requests.component.html'
})
export class RequestsComponent implements OnInit {

    tree: FolderTree[] = [];

    constructor(private storedRequestsService: StoredRequestsService) {
    }

    ngOnInit(): void {
        console.log("ng init RequestsComponent");
        this.storedRequestsService.getAllStoredRequests().subscribe((data: FolderTree[]) =>  {
            this.tree = data;
        });
    }
}