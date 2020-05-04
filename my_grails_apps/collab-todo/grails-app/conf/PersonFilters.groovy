class PersonFilters {
    def filters = {
        personModificationCheck(controller: 'person', action: '*') {
            before = {
                def currActionName = actionName
                if (currActionName == 'edit' || currActionName == 'update' || currActionName == 'delete') {
                    String personId = session?.person?.id
                    String paramsPersonId = params?.id
                    if (personId != paramsPersonId) {
                        flash.message = "You can only modify yourself"
                        redirect(action: 'list')
                        return false
                    }
                }
            }
        } // end personModificationCheck
    }
}

